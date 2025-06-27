import React, { useState } from 'react';

function App() {
    const [submitted, setSubmitted] = useState(false);

    const handleSubmit = () => {
        // Możesz tu dodać logikę POST do backendu
        setSubmitted(true);
    };

    return (
        <div>
            <h1>Produkt</h1>
            <input id="name" placeholder="Produktname" />
            <input id="price" placeholder="Preis" />
            <button id="submit" onClick={handleSubmit}>Hinzufügen</button>

            {submitted && <div id="success">Produkt erfolgreich hinzugefügt!</div>}
        </div>
    );
}

export default App;