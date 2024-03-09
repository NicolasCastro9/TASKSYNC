const express = require('express');
const cors = require('cors');

const app = express();
const PORT = 3000;

// Middleware
app.use(cors());

// Ruta de ejemplo
app.get('/api/datos', (req, res) => {
    const datos = { ejemplo: 'dato' };
    res.json(datos);
});

// Iniciar servidor
app.listen(PORT, () => {
    console.log(`Servidor Node.js en ejecución en el puerto ${PORT}`);
});
