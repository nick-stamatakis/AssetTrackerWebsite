import React from "react";
import { useState } from 'react';
import './Login.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import userEndpoint from "../rest-endpoints/usersEndpoint";

//REST API Endpoint for user authentication
//Use localhost for debugging and real IP for deployment
const url = userEndpoint + '/users/login-check/';

const Login = () => {
  const [inputs, setInputs] = useState({});

  const navigate = useNavigate();

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs(values => ({...values, [name]: value}))
  }

  const handleSubmit = (event) => {
    event.preventDefault();

    const data = JSON.stringify({
      "username": inputs.username,
      "password": inputs.password
    });

    const config = {
      method: 'post',
      url: url,
      headers: { 
        'Content-Type': 'application/json'
      },
      data : data
    };

    axios(config)
    .then(function (response) {
      if(response.data) {
        navigate('/pie-chart');
      } else {
        alert("Incorrect password, try again")
      }
    })
    .catch(function (error) {
      alert(error);
    });
  }

  return(
  <>
    <head>
    <title>Title</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet" />
    <link href="Login.css" rel="stylesheet" />
    <title>Login Form</title>
    </head>
    <body>
    <div class="main-container">
      <div class="container">
        <form onSubmit={handleSubmit}>
          <div>
              
              <center><h1>USER LOGIN</h1></center>

              <div class="input">
                <input 
                  type="text" 
                  name="username" 
                  id="username" 
                  required title="Please enter your Username here" 
                  value={inputs.username || ""} 
                  onChange={handleChange}
                />
                <label for="username">Username</label>
              </div>

              <div class="input">
                <input
                  type="password" 
                  name="password" 
                  id="password" 
                  required title="Please enter your Password here" 
                  value={inputs.password || ""} 
                  onChange={handleChange}
                />
                <label for="password">Password</label>
              </div>

              <input type="submit" value="Login" class="login-btn" />

          </div>
        </form>
      </div>
    </div>
    </body>
  </>
  )
}

export default Login;