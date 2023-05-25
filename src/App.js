import React from 'react';
import { BrowserRouter as Router, Route, Routes  } from 'react-router-dom'; 
import Home from "./pages/Home";
import ProductDetails from "./pages/ProductDetails";
import Sidebar from "./components/Sidebar";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Login from './login/login';
import RegistrationForm from './login/register';


const App = () => {
  return <div>
    <Router>
     
      <Routes>

        <Route path="/" element={<Home />} />
        <Route path="/product/:id" element={<ProductDetails />} />
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<RegistrationForm/>}/>
        </Routes>
       <Sidebar />
     
    </Router>
  </div>;
};

export default App;
