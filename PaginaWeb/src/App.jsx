import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Pages/Home';
import Personajes from './Pages/Personajes';
import Armas from './Pages/Armas';
import Tomos from './Pages/Tomos';
import Objetos from './Pages/Objetos';
import './Componentes/index.css';

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
        <Route path="/armas" element={<Armas />} />
        <Route path="/tomos" element={<Tomos />} />
        <Route path="/objetos" element={<Objetos />} />
      </Routes>
    </Router>
  );
}

export default App;