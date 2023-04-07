import './AddUser.css';
import React from "react";
import { useState } from 'react';
import axios from "axios";
import userEndpoint from '../rest-endpoints/usersEndpoint';

//REST API Endpoint for user authentication
//Use localhost for debugging and real IP for deployment
const url = userEndpoint + '/users/add/';

const AddUser = () => {
    const [inputs, setInputs] = useState({});
  
    const handleChange = (event) => {
      const name = event.target.name;
      const value = event.target.value;
      setInputs(values => ({...values, [name]: value}))
    }
  
    const handleSubmit = (event) => {
      event.preventDefault();
  
      const data = JSON.stringify({
        "userId": 192783817, //Change to random UUID
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
          
        } else {
          alert("Error occurred. Try again")
        }
      })
      .catch(function (error) {
        alert(error);
      });
    }

    return (
      <>
          <head>
              <link href="AddUser.css" rel="stylesheet" />
          </head>
          <body>
              <div class="main-container">
                  <form onSubmit={handleSubmit}>
                      <div class="container">
                          <h1>Add User</h1>
                          <br></br>
                          <p>Please fill in this form to add an account.</p>
                          <hr/>
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

                          <hr/>
                          <button type="submit" class="registerbtn">Add Account</button>
                      </div>
                  </form>
              </div>
          </body>
      </>
  )
}

export default AddUser;