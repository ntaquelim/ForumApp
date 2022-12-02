import FloatingLabel from 'react-bootstrap/FloatingLabel';
import React, { useEffect, useRef, useState } from "react";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import {useNavigate} from 'react-router-dom';


export default function Title(){
    
    const title=useRef();
    const button=useRef();
    const [response, setResponse] = useState();
    const formDiv=document.getElementById("bodyForm");
    
  const navigate = useNavigate();

    const titleHandler = () =>{
      
        (async function call() {
            try {
             const connection = await fetch('http://localhost:8081/post/checkTitle/'+ title.current.value, {
                   method: 'GET',
                   mode: 'cors',
                   headers: {
                    'Content-Type': 'application/json',
                   }, });
             const res = await connection.json();
             setResponse(res)
                }
             catch (error) {
                 console.log('Error with fetching data!', error);
               }
             })();
             console.log(response);
        if(response===true){
            button.current.disabled = false;}
        else{
            button.current.disabled = true;
        }
    }

    const submitHandler = () =>{
        navigate('/BodyForm');
    }
   

    return(
    <div>
        <h5>Insert the title of the post</h5>
       <Form.Control type="text" ref={title} onChange={titleHandler} maxLength={200} placeholder="Max 200 characters!" minLength={1} id="inputTitle" />
       <Button id="submitButton" className="btn btn-primary" disabled={true} ref={button} onClick={submitHandler}>Submit Post</Button>
    </div>
        
    );
}