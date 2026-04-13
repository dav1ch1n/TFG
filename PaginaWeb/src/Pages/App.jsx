import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Personajes from './pages/Personajes'; // El componente que hicimos antes
import './App.css';

// Componentes temporales para las otras secciones
const VistaConstruccion = ({ nombre }) => (
  <div style={{ padding: '50px', textAlign: 'center' }}>
    <h1>Sección de {nombre}</h1>
    <p>Próximamente... estamos conectando con el Back-end.</p>
    <a href="/">Volver al inicio</a>
  </div>
);

function App() {
  return (
    <Router>
      <Routes>
        {/* Ruta principal con el menú de 4 botones */}
        <Route path="/" element={<Home />} />

        {/* Rutas enlazadas */}
        <Route path="/personajes" element={<Personajes />} />
        <Route path="/armas" element={<VistaConstruccion nombre="Armas" />} />
        <Route path="/tomos" element={<VistaConstruccion nombre="Tomos" />} />
        <Route path="/objetos" element={<VistaConstruccion nombre="Objetos" />} />
      </Routes>
    </Router>
  );
}

export default App;