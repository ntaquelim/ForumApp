import React, {  useRef, useState } from "react";
import {useNavigate} from 'react-router-dom';


export default function Title(){
    
    const title=useRef();
    const button=useRef();
    const [response, setResponse] = useState(true);
    const navigate = useNavigate();

    const titleHandler = (e) =>{
        e.preventDefault();
        (async function call() {
            try {
             const connection = await fetch('http://localhost:8081/post/checkTitle/'+ title.current.value, {
                   method: 'GET',
                   mode: 'cors',
                   headers: {
                    'Content-Type': 'application/json',
                   }, });
             const res = await connection.json();
             if( res != undefined){
                setResponse(res);
             }
                }
             catch (error) {
                 console.log('Error with fetching data!', error);
               }
             })();
    }

    const clickHandler = () =>{
        localStorage.setItem("postTitle",title.current.value)
        navigate('/PostBodyForm')
    }
   

    return(
    <div>
        <h5>Insert the title of the post</h5>
       <input type="text" ref={title} onChangeCapture={titleHandler} maxLength={200} placeholder="Max 200 characters!" minLength={1} id="inputTitle" />
       <button onClick={clickHandler} id="button" ref={button} disabled={response}>Submit title</button>
    </div>
        
    );
}