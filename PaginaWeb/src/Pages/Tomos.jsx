import { useEffect, useState } from 'react';
import { TomosService } from '../Service/TomosService';
import TablasGenerica from '../Componentes/TablasGenericas.jsx';
import Modal from '../Componentes/Modal.jsx';

function Tomos() {
  const [Tomos, setTomos] = useState([]);
  // Estado para controlar qué personaje está seleccionado para el Popup
  const [Tomoseleccionado, setTomoseleccionado] = useState(null);
const abrirDetalles = (item) => {
  setTomoseleccionado(item);
};
  useEffect(() => {
    TomosService().then(setTomos).catch(console.error);
  }, []);

  return (
    <>
      {/*USAMOS LA TABLA COMÚN */}
      <TablasGenerica
        titulo="Tomos"
        datos={Tomos}
        carpetaImg="Tomos"
        campoSubtitulo="descripcion"
        onInfoClick={abrirDetalles}
      />

      {/*EL MODAL (LA VENTANA FLOTANTE) */}
      <Modal isOpen={Tomoseleccionado !== null} onClose={() => setTomoseleccionado(null)}>
        {Tomoseleccionado && (
          <div style={{ textAlign: 'center',  fontSize: '25px', }}>
            {/* Cabecera del Modal (Foto y Nombre) */}
            <img
                          src={`/src/img/Tomos/${Tomoseleccionado.nombre}.png`}
                          alt={Tomoseleccionado.nombre}
                          style={{ width: '150px', height: '150px', borderRadius: '10px', marginBottom: '15px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                          onError={(e) => {
                            e.target.onerror = null;
                            e.target.src = '/src/assets/hero.png';
                          }}
                        />
            <h2 style={{ color: '#e67e22' }}>{Tomoseleccionado.nombre}</h2>
            <p style={{ fontStyle: 'italic', marginBottom: '20px' }}>"{Tomoseleccionado.descripcion}"</p>

            <div style={{ display: 'flex', gap: '20px', textAlign: 'left' }}>

              {/* Tabla 1: Datos Base (Ficha Técnica) */}
              <div style={{ flex: 1, backgroundColor: '#1a252f', padding: '15px', borderRadius: '8px', fontSize: '25px', }}>
                <h4 style={{ borderBottom: '1px solid #e67e22', marginBottom: '10px' }}>Ficha Técnica</h4>
                <p style={{ margin: '5px 0' }}><strong>Tomo:</strong> {Tomoseleccionado.nombre}</p>
                <p style={{ margin: '5px 0' }}><strong>Descripción:</strong> {Tomoseleccionado.descripcion}</p>
                <p style={{ margin: '5px 0' }}><strong>Estadistica que sube:</strong> {Tomoseleccionado.estadisticaSubir}</p>
                <p style={{ margin: '5px 0' }}><strong>Obtención:</strong> {Tomoseleccionado.obtencion}</p>
              </div>
            </div>
          </div>
        )}
      </Modal>
    </>
  );
}

export default Tomos;