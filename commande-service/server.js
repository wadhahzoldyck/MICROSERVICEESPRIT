import express from 'express';
import { commandeData as commande } from './commande.js';


const app = express();


app.get('/commande',(req, res)=>{
    res.send(commande)
    console.log(commande)
})



const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Server is running  http://localhost:${port}`);
});