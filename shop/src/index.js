const express = require('express');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;

// Sirve archivos estáticos si tienes CSS, JS, imágenes, etc.
app.use(express.static(path.join(__dirname, '../public')));

// Redirige la ruta raíz a tu HTML
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'templates/index.html'));
});

app.listen(PORT, () => {
  console.log(`Servidor escuchando en puerto ${PORT}`);
});
