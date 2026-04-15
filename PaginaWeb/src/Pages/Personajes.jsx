import { useEffect, useState } from 'react';
import { PersonajesService } from '../Service/PersonajesService';
import Modal from '../Componentes/Modal.jsx';

function Personajes() {
  const [personajes, setPersonajes] = useState([]);

  // Estado para controlar qué personaje está seleccionado para el Popup
  const [personajeSeleccionado, setPersonajeSeleccionado] = useState(null);

  useEffect(() => {
    PersonajesService().then(setPersonajes).catch(console.error);
  }, []);

  return (
    <div style={{ padding: '20px', color: 'white' }}>
      <h2>Lista de Personajes</h2>
      <a href="/" style={{ color: '#aaa' }}>⬅ Volver al Menú</a>

      <div style={{ display: 'flex', flexDirection: 'column', gap: '15px', marginTop: '20px' }}>
        {personajes.map((p) => (
          // Tabla padre
          <div key={p.idPersonajes} style={{ display: 'flex', backgroundColor: '#34495e', padding: '15px', borderRadius: '8px', alignItems: 'center' }}>

            <div style={{ flex: '1' }}>
              <div style={{ width: '80px', height: '80px', backgroundColor: '#1abc9c', borderRadius: '8px', display: 'flex', alignItems:'center', justifyContent:'center'}}>
                IMG
              </div>
            </div>

            <div style={{ flex: '3', padding: '0 20px' }}>
              <h3>{p.nombre}</h3>
              <p>{p.descripcion}</p>
            </div>

            <div style={{ flex: '1', textAlign: 'right' }}>
              <button
                onClick={() => setPersonajeSeleccionado(p)}
                style={{ padding: '10px 20px', cursor: 'pointer', backgroundColor: '#e67e22', color: 'white', border: 'none', borderRadius: '5px', fontWeight: 'bold' }}>
                + Info
              </button>
            </div>
          </div>
        ))}
      </div>

      {/* EL POPUP (MODAL) */}
      <Modal
        isOpen={personajeSeleccionado !== null}
        onClose={() => setPersonajeSeleccionado(null)}
      >
        {personajeSeleccionado && (
          <div>
            <h2>{personajeSeleccionado.nombre}</h2>

            {/* Contenedor Flex para poner las dos tablas lado a lado */}
            <div style={{ display: 'flex', gap: '30px', marginTop: '20px' }}>

              {/* Tabla 1: Datos Base */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px' }}>
                <h3 style={{ borderBottom: '1px solid #555', paddingBottom: '10px' }}>Datos Generales</h3>
                <p><strong>Arma:</strong> {personajeSeleccionado.nombreArma}</p>
                <p><strong>Habilidad:</strong> {personajeSeleccionado.habilidad}</p>
                <p><strong>Obtención:</strong> {personajeSeleccionado.obtencion}</p>
              </div>

              {/* Tabla 2: Estadísticas */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px' }}>
                <h3 style={{ borderBottom: '1px solid #555', paddingBottom: '10px' }}>Estadísticas Base</h3>
                <p><em>(Aquí irán las estadísticas haciendo una llamada a /estadisticas/{personajeSeleccionado.idPersonajes})</em></p>
                <p><strong>Vida:</strong> 100</p>
                <p><strong>Armadura:</strong> 10</p>
              </div>

            </div>
          </div>
        )}
      </Modal>
    </div>
  );
}

export default Personajes;