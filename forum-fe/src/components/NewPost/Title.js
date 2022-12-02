import React, {  useRef, useState } from "react";
import {useNavigate} from 'react-router-dom';


export default function Title(){
    
    const title=useRef();
    const button=useRef();
    const [response, setResponse] = useState();
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
        if(response===true){
            button.current.disabled = false;}
        else{
            button.current.disabled = true;
        }
    }
    const clickHandler = () =>{
        localStorage.setItem("postTitle",title.current.value)
        navigate('/PostBodyForm')
    }
   

    return(
    <div>
        <h5>Insert the title of the post</h5>
       <input type="text" ref={title} onChange={titleHandler} maxLength={200} placeholder="Max 200 characters!" minLength={1} id="inputTitle" />
       <button onClick={clickHandler} id="button" ref={button}>Submit Post</button>
    </div>
        
    );
}