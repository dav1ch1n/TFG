import { useEffect, useState } from 'react';
import { ObjetosService } from '../Service/ObjetosService';
import TablasGenerica from '../Componentes/TablasGenericas.jsx';
import Modal from '../Componentes/Modal.jsx';

function Objetos() {
  const [Objetos, setObjetos] = useState([]);
  // Estado para controlar qué personaje está seleccionado para el Popup
  const [Objetoseleccionado, setObjetoseleccionado] = useState(null);
  const abrirDetalles = (item) => {
    setObjetoseleccionado(item);
  };

  useEffect(() => {
    ObjetosService().then(setObjetos).catch(console.error);
  }, []);

  return (
    <>
      {/* 1. USAMOS LA TABLA COMÚN */}
      <TablasGenerica
        titulo="Compendio de Objetos"
        datos={Objetos}
        carpetaImg="Objetos"
        campoSubtitulo="descripcion"
        onInfoClick={abrirDetalles}
      />

      {/* 2. EL MODAL (LA VENTANA FLOTANTE) */}
      <Modal isOpen={Objetoseleccionado !== null} onClose={() => setObjetoseleccionado(null)}>
        {Objetoseleccionado && (
          <div style={{ textAlign: 'center',  fontSize: '25px', }}>
            {/* Cabecera del Modal (Foto y Nombre) */}
            <img
                          src={`/src/img/Objetos/${Objetoseleccionado.nombre}.png`}
                          alt={Objetoseleccionado.nombre}
                          style={{ width: '150px', height: '150px', borderRadius: '10px', marginBottom: '15px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                          onError={(e) => {
                            e.target.onerror = null;
                            e.target.src = '/src/assets/hero.png';
                          }}
                        />
            <h2 style={{ color: '#e67e22' }}>{Objetoseleccionado.nombre}</h2>
            <p style={{ fontStyle: 'italic', marginBottom: '20px' }}>"{Objetoseleccionado.descripcion}"</p>

            <div style={{ display: 'flex', gap: '20px', textAlign: 'left' }}>

              {/* Tabla 1: Datos Base (Ficha Técnica) */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px', fontSize: '25px', }}>
                <h4 style={{ borderBottom: '1px solid #e67e22', marginBottom: '10px' }}>Ficha Técnica</h4>
                <p style={{ margin: '5px 0' }}><strong>Objeto:</strong> {Objetoseleccionado.nombre}</p>
                <p style={{ margin: '5px 0' }}><strong>Descripción:</strong> {Objetoseleccionado.descripcion}</p>
                <p style={{ margin: '5px 0' }}><strong>¿Sube estadistica?:</strong> {Objetoseleccionado.estadisticasSubir ? "Sí" : "No"}</p>
                <p style={{ margin: '5px 0' }}><strong>Obtención:</strong> {Objetoseleccionado.obtencion}</p>
                <p style={{ margin: '5px 0' }}><strong>Categoria:</strong> {Objetoseleccionado.categoria}</p>
              </div>
            </div>
          </div>
        )}
      </Modal>
    </>
  );
}

export default Objetos;