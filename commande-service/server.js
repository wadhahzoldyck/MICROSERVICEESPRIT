import express from 'express';
import axios from 'axios';
import mongoose from 'mongoose';
import dotenv from "dotenv";
import Commande from './Model/commandeModel.js';
import { registerWithEureka } from './eureka.js'; // Updated import statement


dotenv.config();


const app = express();
app.use(express.json());


registerWithEureka('commande-service', 3000); // Utilisez le bon nom d'application et le port


mongoose
  .connect(process.env.MONGODB_URI)
  .then(() => {
    console.log("connected to db");
  })
  .catch((err) => {
    console.log(err.message);
  });


app.get('/commande', (req, res) => {
    const apiUrl = 'http://localhost:8081/Product/getAllProduct'

    axios.get(apiUrl)
      .then(response => {
        const products = response.data; 
        console.log(products); 
        res.send(products); 
      })
      .catch(error => {
        console.error('Error fetching products:', error);
        res.status(500).send('Error fetching products'); // Send an error response to the client
      });
  });


  function convertToObjectId(id) {
    try {
      return mongoose.Types.ObjectId(id);
    } catch (error) {
      throw new Error('Invalid ObjectId');
    }
  }
  
  app.post('/addCommande', async (req, res) => {
    try {
      console.log(req.body); 
  
      const productsResponse = await axios.get(`http://172.19.0.5:8091/Product/getProduct/${req.body.id}`);
      const product = productsResponse.data;
  
      if (product.qte >= req.body.qte) {
        const newCommande = new Commande({
          orderItems: [
            {
              name: product.nomProduit,
              quantity: req.body.qte,
              image: product.image,
              price: product.prix,
            },
          ],
        });
  
        const savedCommande = await newCommande.save();
        res.status(201).json(savedCommande);
      } else {
        res.status(400).send('Requested quantity exceeds available product quantity');
      }
    } catch (error) {
      console.error('Error creating Commande:', error);
      res.status(500).send('Error creating Commande');
    }
  });
  

const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Server is running  http://localhost:${port}`);
});


