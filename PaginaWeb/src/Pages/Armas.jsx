import { useEffect, useState } from 'react';
import { ArmasService } from '../Service/ArmasService';
import TablasGenerica from '../Componentes/TablasGenericas.jsx';
import Modal from '../Componentes/Modal.jsx';

function Armas() {
  const [Armas, setArmas] = useState([]);
  // Estado para controlar qué personaje está seleccionado para el Popup
  const [Armaseleccionado, setArmaseleccionado] = useState(null);
  const abrirDetalles = (item) => {
      setArmaseleccionado(item);
  };
  useEffect(() => {
    ArmasService().then(setArmas).catch(console.error);
  }, []);

  return (
    <>
      {/* 1. USAMOS LA TABLA COMÚN */}
      <TablasGenerica
        titulo="Compendio de Armas"
        datos={Armas}
        carpetaImg="Armas"
        campoSubtitulo="descripcion"
        onInfoClick={abrirDetalles}
      />

      {/* 2. EL MODAL (LA VENTANA FLOTANTE) */}
      <Modal isOpen={Armaseleccionado !== null} onClose={() => setArmaseleccionado(null)}>
        {Armaseleccionado && (
          <div style={{ textAlign: 'center',  fontSize: '25px', }}>
            {/* Cabecera del Modal (Foto y Nombre) */}
            <img
                          src={`/src/img/Armas/${Armaseleccionado.nombre}.png`}
                          alt={Armaseleccionado.nombre}
                          style={{ width: '150px', height: '150px', borderRadius: '10px', marginBottom: '15px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                          onError={(e) => {
                            e.target.onerror = null;
                            e.target.src = '/src/assets/hero.png';
                          }}
                        />
            <h2 style={{ color: '#e67e22' }}>{Armaseleccionado.nombre}</h2>
            <p style={{ fontStyle: 'italic', marginBottom: '20px' }}>"{Armaseleccionado.descripcion}"</p>

            <div style={{ display: 'flex', gap: '20px', textAlign: 'left' }}>

              {/* Tabla 1: Datos Base (Ficha Técnica) */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px', fontSize: '25px', }}>
                <h4 style={{ borderBottom: '1px solid #e67e22', marginBottom: '10px' }}>Ficha Técnica</h4>
                <p style={{ margin: '5px 0' }}><strong>Arma:</strong> {Armaseleccionado.nombre}</p>
                <p style={{ margin: '5px 0' }}><strong>Descripción:</strong> {Armaseleccionado.descripcion}</p>
                <p style={{ margin: '5px 0' }}><strong>Afinidad:</strong> {Armaseleccionado.afinidad }</p>
                <p style={{ margin: '5px 0' }}><strong>Obtención:</strong> {Armaseleccionado.obtencion}</p>
              </div>
            </div>
          </div>
        )}
      </Modal>
    </>
  );
}

export default Armas;