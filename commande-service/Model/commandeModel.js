import mongoose from 'mongoose';

const orderItemSchema = new mongoose.Schema({
  name: { type: String, required: true },
  quantity: { type: Number, required: true },
  image: { type: String, required: true },
  price: { type: Number, required: true },

});

const orderSchema = new mongoose.Schema({
  orderItems: [orderItemSchema],
  // Ajoutez d'autres champs pour une commande si nécessaire
  // Par exemple : utilisateur, adresse de livraison, prix total, etc.
});

const Commande = mongoose.model('Commande', orderSchema);

export default Commande;
