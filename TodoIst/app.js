  import { initializeApp } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-app.js";
  import { getFirestore, collection, getDocs, addDoc, serverTimestamp, deleteDoc, updateDoc, doc } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-firestore.js"

  const firebaseConfig = {
    apiKey: "AIzaSyCup1WdAmL00hdJg-zCor_Pgp39pDbzIS4",
    authDomain: "todolist-19897.firebaseapp.com",
    projectId: "todolist-19897",
    storageBucket: "todolist-19897.appspot.com",
    messagingSenderId: "774728966787",
    appId: "1:774728966787:web:f0f7600ea52f7b607db1b6"
  };

  // Inicializando Firebase
  const app = initializeApp(firebaseConfig);

  const db = getFirestore(app);
  const task = collection(db,'Tasks');

  const querySnapchot = await getDocs(task)