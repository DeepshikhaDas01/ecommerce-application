import React, { useState } from 'react';
import './login.css'; 
import { Link } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

   
    if (!email || !/\S+@\S+\.\S+/.test(email)) {
      setErrorMessage('Please enter a valid email address');
      return;
    }

    
    if (!password || password.length < 6) {
      setErrorMessage('Please enter a password with at least 6 characters');
      return;
    }

    
    console.log('Email:', email);
    console.log('Password:', password);

 
    setEmail('');
    setPassword('');
    setErrorMessage('');
  };

  return (
    <div className="login-container">
     
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

      <h2><i className="fas fa-lock"></i> Login</h2>
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="email">
            <i className="fas fa-envelope"></i> Email:
          </label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={handleEmailChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">
            <i className="fas fa-lock"></i> Password:
          </label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={handlePasswordChange}
            className="form-control"
          />
        </div>
        <button type="submit" className="btn-login">Login</button>
      </form>
      <div className="additional-options">
        <a href="#" className="forgot-password">Forgot Password?</a>
        <Link to="/register">
        <button type="button" className="btn-signup">Sign Up</button>
        </Link>
      </div>
    </div>
  );
};

export default Login;
