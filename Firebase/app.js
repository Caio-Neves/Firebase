import { initializeApp } from "https://www.gstatic.com/firebasejs/9.14.0/firebase-app.js";
import { getFirestore, collection, getDocs, addDoc, serverTimestamp, deleteDoc, updateDoc, doc } from "https://www.gstatic.com/firebasejs/9.14.0/firebase-firestore.js"

const app = initializeApp({
  apiKey: "AIzaSyAkNL0r2eR-yX22fnd1HBvX9HbrHWyP2ZE",
  authDomain: "movie-list-92c50.firebaseapp.com",
  projectId: "movie-list-92c50",
  storageBucket: "movie-list-92c50.appspot.com",
  messagingSenderId: "524043761730",
  appId: "1:524043761730:web:3a61780746893f5fff55db",
  measurementId: "G-BJH89WBK0E"
});

// Criamos uma constante que armazena nosso banco de dados
const db = getFirestore(app);
// Criamos uma constante que 
const food = collection(db,'foods')

const querySnapchot = await getDocs(food);

const foodsList = document.querySelector('[data-js="show-menu"]')

querySnapchot.forEach((doc) => {
  const {comida, bebida} = doc.data()

  foodsList.innerHTML +=
  `
  <tr>
      <td>${comida}<button class="btn" data-remove="${doc.id}">Excluir</button></td>
      <td>${bebida}<button class="btn" data-remove="${doc.id}">Excluir</button></td>
  </tr>
  `
})

const buttons = document.querySelectorAll(".btn")

buttons.forEach((btn) => {
  btn.addEventListener('click',() =>{
    console.log(btn.dataset.remove);
    deleteDoc(doc(food,btn.dataset.remove))
  })
})

// const docRef = doc(movie, doc.id)
// updateDoc(docRef,{
//   name: "Vingado"
// })

const addFood = document.querySelector('[data-js="add-food-form"]');

addFood.addEventListener('submit',e =>{
  e.preventDefault();

  addDoc(food,{
    comida:e.target.comida.value,
    bebida:e.target.bebida.value,
  }).then(doc => console.log("Comida adicionada com sucesso!", doc.id));
})

// moviesList.addEventListener('click', e =>{
//   const removeButtonId = e.target.dataset.remove

//   if(removeButtonId){
//     db.collection('filmes').doc(removeButtonId).delete()
//       .then(() => {
//         console.log('Filme removido');
//       })
//       .catch(e => {
//         console.log('Erro ao remover o filme', e.message);
//       })
//   } 
// })

// addDoc(movie,{
//   name:"Trem bala",
//   directedBy:"David Leitch",
//   studio:"Sony",
//   createdAt:serverTimestamp(),
// })



