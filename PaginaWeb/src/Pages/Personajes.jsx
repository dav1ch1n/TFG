import { useEffect, useState } from 'react';
import { PersonajesService } from '../Service/PersonajesService';
import { EstadisticasService } from '../Service/EstadisticasService';
import TablasGenerica from '../Componentes/TablasGenericas.jsx';
import Modal from '../Componentes/Modal.jsx';

function Personajes() {
    const [personajes, setPersonajes] = useState([]);
    const [personajeSeleccionado, setPersonajeSeleccionado] = useState(null);
    const [stats, setStats] = useState(null);

    const [tabActiva, setTabActiva] = useState('info');

    useEffect(() => {
        PersonajesService().then(setPersonajes).catch(console.error);
    }, []);

    const abrirDetalles = async (p) => {
        setPersonajeSeleccionado(p);
        setStats(null);
        setTabActiva('info'); // Al abrir, empezamos siempre por la info
        try {
            const data = await EstadisticasService(p.idPersonajes);
            const estadisticasReales = Array.isArray(data)
                ? data.find(s => s.nombrePersonaje === p.nombre)
                : data;
            setStats(estadisticasReales);
        } catch (error) {
            console.error("Error cargando estadísticas", error);
        }
    };

    // Estilos para los botones de las pestañas
    const tabButtonStyle = (isActive, color) => ({
        flex: 1,
        padding: '12px',
        backgroundColor: isActive ? color : '#2c3e50',
        color: 'white',
        border: 'none',
        cursor: 'pointer',
        fontSize: '18px',
        fontWeight: 'bold',
        transition: '0.3s',
        borderBottom: isActive ? `4px solid white` : '4px solid transparent'
    });

    return (
        <>
            <TablasGenerica
                titulo="Personajes"
                datos={personajes}
                carpetaImg="Personajes"
                campoSubtitulo="descripcion"
                onInfoClick={abrirDetalles}
            />

            <Modal isOpen={personajeSeleccionado !== null} onClose={() => setPersonajeSeleccionado(null)}>
                {personajeSeleccionado && (
                    <div style={{ textAlign: 'center' }}>
                        {/* Cabecera: Siempre visible */}
                        <img
                            src={`/src/img/Personajes/${personajeSeleccionado.nombre}.png`}
                            alt={personajeSeleccionado.nombre}
                            style={{ width: '120px', height: '120px', borderRadius: '10px', marginBottom: '10px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                            onError={(e) => { e.target.src = '/src/assets/hero.png'; }}
                        />
                        <h2 style={{ color: '#e67e22', margin: '0' }}>{personajeSeleccionado.nombre}</h2>
                        <p style={{ fontStyle: 'italic', color: '#bdc3c7', fontSize: '16px' }}>"{personajeSeleccionado.descripcion}"</p>

                        {/* Selector de Pestañas (Visible solo en móvil/ajustado) */}
                        <div style={{ display: 'flex', marginTop: '20px', borderRadius: '8px 8px 0 0', overflow: 'hidden' }}>
                            <button
                                onClick={() => setTabActiva('info')}
                                style={tabButtonStyle(tabActiva === 'info', '#e67e22')}
                            >
                                Ficha Técnica
                            </button>
                            <button
                                onClick={() => setTabActiva('stats')}
                                style={tabButtonStyle(tabActiva === 'stats', '#3498db')}
                            >
                                Atributos
                            </button>
                        </div>

                        {/* Contenedor de Contenido */}
                        <div style={{ backgroundColor: '#1a252f', padding: '20px', borderRadius: '0 0 8px 8px', textAlign: 'left', minHeight: '300px' }}>

                            {/*FICHA TÉCNICA */}
                            {tabActiva === 'info' && (
                            <div style={{ animation: 'fadeIn 0.3s' }}>
                                <h4 style={{ color: '#e67e22', borderBottom: '1px solid #e67e22', marginBottom: '15px', paddingBottom: '5px' }}>Detalles</h4>
                                <p style={{ fontSize: '20px', margin: '10px 0' }}><strong>Arma:</strong> {personajeSeleccionado.nombreArma}</p>
                                <p style={{ fontSize: '20px', margin: '10px 0' }}><strong>Descripción:</strong> {personajeSeleccionado.descripcion}</p>
                                <p style={{ fontSize: '20px', margin: '10px 0' }}><strong>Habilidad:</strong> {personajeSeleccionado.habilidad}</p>
                                <p style={{ fontSize: '20px', margin: '10px 0' }}><strong>Obtención:</strong> {personajeSeleccionado.obtencion}</p>
                            </div>
                            )}


                            {tabActiva === 'stats' && (
                                <div style={{ animation: 'fadeIn 0.3s' }}>
                                    <h4 style={{ color: '#3498db', borderBottom: '1px solid #3498db', marginBottom: '15px', paddingBottom: '5px' }}>Atributos Base</h4>
                                    {!stats ? (
                                        <p>Cargando estadísticas...</p>
                                    ) : (
                                        <div className="stats-grid">
                                            {Object.entries(stats).map(([clave, valor]) => {
                                                if (['idEstadistica', 'id', 'personaje', 'idPersonaje', 'nombrePersonaje'].includes(clave)) return null;
                                                if (typeof valor === 'object') return null;

                                                const nombreFormateado = clave
                                                    .replace(/([A-Z])/g, ' $1')
                                                    .replace(/^./, (str) => str.toUpperCase());

                                                return (
                                                    <div key={clave} style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 0', borderBottom: '1px solid #2c3e50', fontSize: '18px' }}>
                                                        <span style={{ color: '#bdc3c7' }}>{nombreFormateado}</span>
                                                        <span style={{ fontWeight: 'bold', color: '#3498db' }}>{valor ?? '0'}</span>
                                                    </div>
                                                );
                                            })}
                                        </div>
                                    )}
                                </div>
                            )}
                        </div>
                    </div>
                )}
            </Modal>
        </>
    );
}

export default Personajes;