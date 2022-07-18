// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAUC7CfLvpYdaETWxEwQhmKUDfFkNoTmdI",
  authDomain: "proto-77b8f.firebaseapp.com",
  projectId: "proto-77b8f",
  storageBucket: "proto-77b8f.appspot.com",
  messagingSenderId: "406713971805",
  appId: "1:406713971805:web:466a458a2dca5c7fd909b4",
  measurementId: "G-V2CVJSHZ7K",
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

const storageRef = firebase.storage().ref("/blood-bank");
