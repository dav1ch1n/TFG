import React from 'react';
import './Modal.css';

function Modal({ isOpen, onClose, children }) {
  if (!isOpen) return null; // Si no está abierto, no renderiza nada

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <button className="modal-close-btn" onClick={onClose}>X</button>
        {children}
      </div>
    </div>
  );
}

export default Modal;