import { useEffect, useState } from 'react';
import { PersonajesService } from '../Service/PersonajesService';
import { EstadisticasService } from '../Service/EstadisticasService';
import TablasGenerica from '../Componentes/TablasGenericas.jsx';
import Modal from '../Componentes/Modal.jsx';

function Personajes() {
  const [personajes, setPersonajes] = useState([]);
  // Estado para controlar qué personaje está seleccionado para el Popup
  const [personajeSeleccionado, setPersonajeSeleccionado] = useState(null);
  // Estadisticas
  const [stats, setStats] = useState(null);

  useEffect(() => {
    PersonajesService().then(setPersonajes).catch(console.error);
  }, []);

const abrirDetalles = async (p) => {
  setPersonajeSeleccionado(p);
  setStats(null);
  try {
      const data = await EstadisticasService(p.idPersonajes);

      // BUSQUEDA DINÁMICA:
      // Si 'data' es un Array, buscamos el objeto donde 'nombrePersonaje' coincida con 'p.nombre'
      const estadisticasReales = Array.isArray(data)
        ? data.find(s => s.nombrePersonaje === p.nombre)
        : data;
      // Si por alguna razón .find() no encuentra nada, 'estadisticasReales' será undefined.
      if (!estadisticasReales) {
          console.warn("No se encontraron estadísticas para:", p.nombre);
      }
      setStats(estadisticasReales);
    } catch (error) {
      console.error("Error cargando estadísticas", error);
    }
};

  return (
    <>
      {/* 1. USAMOS LA TABLA COMÚN */}
      <TablasGenerica
        titulo="Compendio de Personajes"
        datos={personajes}
        carpetaImg="Personajes"
        campoSubtitulo="descripcion"
        onInfoClick={abrirDetalles}
      />

      {/* 2. EL MODAL (LA VENTANA FLOTANTE) */}
      <Modal isOpen={personajeSeleccionado !== null} onClose={() => setPersonajeSeleccionado(null)}>
        {personajeSeleccionado && (
          <div style={{ textAlign: 'center',  fontSize: '25px', }}>
            {/* Cabecera del Modal (Foto y Nombre) */}
            <img
                          src={`/src/img/Personajes/${personajeSeleccionado.nombre}.png`}
                          alt={personajeSeleccionado.nombre}
                          style={{ width: '150px', height: '150px', borderRadius: '10px', marginBottom: '15px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                          onError={(e) => {
                            e.target.onerror = null;
                            e.target.src = '/src/assets/hero.png';
                          }}
                        />
            <h2 style={{ color: '#e67e22' }}>{personajeSeleccionado.nombre}</h2>
            <p style={{ fontStyle: 'italic', marginBottom: '20px' }}>"{personajeSeleccionado.descripcion}"</p>

            <div style={{ display: 'flex', gap: '20px', textAlign: 'left' }}>

              {/* Tabla 1: Datos Base (Ficha Técnica) */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px', fontSize: '25px', }}>
                <h4 style={{ borderBottom: '1px solid #e67e22', marginBottom: '10px' }}>Ficha Técnica</h4>
                <p style={{ margin: '5px 0' }}><strong>Arma:</strong> {personajeSeleccionado.nombreArma}</p>
                <p style={{ margin: '5px 0' }}><strong>Descripción:</strong> {personajeSeleccionado.descripcion}</p>
                <p style={{ margin: '5px 0' }}><strong>Habilidad:</strong> {personajeSeleccionado.habilidad}</p>
                <p style={{ margin: '5px 0' }}><strong>Obtención:</strong> {personajeSeleccionado.obtencion}</p>
              </div>

              {/* Tabla 2: Estadísticas Reales (El bloque automático) */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px', fontSize: '25px',}}>
                <h4 style={{ borderBottom: '1px solid #3498db', marginBottom: '10px' }}>Atributos</h4>

                {!stats ? (
                  <p>Cargando estadísticas...</p>
                ) : (
                  <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '10px', }}>
                    {Object.entries(stats).map(([clave, valor]) => {
                      // 1. Ocultar datos técnicos
                      if (clave === 'idEstadistica' || clave === 'id' || clave === 'personaje' || clave === 'idPersonaje' || clave === 'nombrePersonaje') {
                        return null;
                      }

                      // 2. Seguridad contra objetos
                      if (typeof valor === 'object' && valor !== null) return null;

                      const nombreFormateado = clave
                        .replace(/([A-Z])/g, ' $1')
                        .replace(/_/g, ' ') // También quitamos guiones bajos si los hay
                        .replace(/^./, (str) => str.toUpperCase());

                      return (
                        <div key={clave} style={{
                          display: 'flex',
                          justifyContent: 'space-between', // Nombre a la izquierda, número a la derecha
                          alignItems: 'flex-start',       // Si el nombre es muy largo, el número se queda arriba
                          padding: '6px 0',
                          borderBottom: '1px solid #2c3e50', // Una línea sutil para separar
                          fontSize: '20px'
                        }}>
                          <span style={{ color: '#bdc3c7', paddingRight: '10px', flex: '1' }}>
                            {nombreFormateado}
                          </span>
                          <span style={{ fontWeight: 'bold', color: '#3498db', textAlign: 'right' }}>
                            {valor !== null ? valor : '0'}
                          </span>
                        </div>
                      );
                    })}
                  </div>
                )}
              </div>
            </div>
          </div>
        )}
      </Modal>
    </>
  );
}

export default Personajes;