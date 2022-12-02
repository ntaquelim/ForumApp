import FloatingLabel from 'react-bootstrap/FloatingLabel';
import React, { useRef } from "react";
import Form from 'react-bootstrap/Form';
import pencil from './images/pencil.png';
import question from './images/question.jpg';
import speaker from './images/speaker.jpg';

localStorage.setItem("source",question);


export default function BodyForm(){

  let imgHandler = (event) => {
    let radioId=event.currentTarget.id
    
    if(radioId==="1"){
         localStorage.clear()
         localStorage.setItem("source",question);
    }
    
    if(radioId==="2"){
        localStorage.clear()
        localStorage.setItem("source",speaker)
    }
    if(radioId==="3"){
        localStorage.clear()
        localStorage.setItem("source",pencil)
     } 
}

    return(
        <Form>
           <div className="radioOption">
           <h5>Category</h5>
            <Form.Check inline type="radio" label="Question" name="category" id="1"  onChange={imgHandler} defaultChecked/>
            <Form.Check inline type="radio" label="Suggestion" name="category" id="2" onChange={imgHandler}/>
            <Form.Check inline type="radio" label="Clarification" name="category" id="3" onChange={imgHandler} />
           </div>
           <div className='textOption'>
            <h5>Body</h5>
            <Form.Control as="textarea" rows={3} maxLength={2000} placeholder="Max 2000 characters!"/>
           </div>
           <div>
           <img id="image" src={localStorage.getItem("source")}></img>        
           </div>
        </Form>
    );
}