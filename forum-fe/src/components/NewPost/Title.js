import FloatingLabel from 'react-bootstrap/FloatingLabel';
import React, { useRef } from "react";
import Form from 'react-bootstrap/Form';


export default function Title(){
   
    const title=useRef();

    const titleHandler = () =>{

    }

    return(
    <div>
        <h5>Insert the title of the post</h5>
       <Form.Control type="text" ref={title} onChange={titleHandler} maxLength={200} placeholder="Max 200 characters!"/>
    </div>
        
    );
}