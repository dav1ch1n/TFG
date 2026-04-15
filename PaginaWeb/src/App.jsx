import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Pages/Home';
import Personajes from './Pages/Personajes' // Necesitamos crear esto ahora
import './App.css';

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
        <Route path="/" element={<Home />} />
        <Route path="/personajes" element={<Personajes />} />
        <Route path="/armas" element={<VistaConstruccion nombre="Armas" />} />
        <Route path="/tomos" element={<VistaConstruccion nombre="Tomos" />} />
        <Route path="/objetos" element={<VistaConstruccion nombre="Objetos" />} />
      </Routes>
    </Router>
  );
}

export default App;