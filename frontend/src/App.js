import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import React, { useState } from 'react';

function App() {

  const [status, setStatus]  = useState(null);;

  const myfun = ()=>{
    console.log("Working fine...............")
    axios({
        method: 'post',
        url: 'http://localhost:8081/authenticate/lo',
        data: {
          userName: 'sohel',
          userPassword: 'sohel'
        },
        headers: {'Authorization': ''}
      }).then(res=>{
        setStatus(res.data.statusCode);
        console.log(res.data.jwtToken);
        localStorage.setItem('token', res.data.jwtToken);
      }).catch(error=>{
        setStatus(error.response.data.code);
        console.log(error.response);
      })
  }

    const retrive = ()=>{
    var data = '';

        var config = {
          method: 'get',
          url: 'http://localhost:8081/hello',
          headers: { 
            'Authorization': 'Bearer '+localStorage.getItem("token")
          },
          data : data
        };

        axios(config)
          .then(function (response) {
            
            console.log(response);
            console.log(JSON.stringify(response.data));
          })
          .catch(function (error) {

            console.log(error.response);
        });
  }

  return (
    <div className="App">
         <input type="button" value="submit" onClick={myfun} />
         <input type="button" value="Retrive Data" onClick={retrive} />

         {status == 200
           ? (<h1>Login sucess</h1>)
           : status ==401? (<h1>Login Failed</h1>) : null
          }
    </div>
  );
}

export default App;
