
import React, { useRef, useState } from "react";
import Form from 'react-bootstrap/Form';
import pencil from './images/pencil.png';
import question from './images/question.jpg';
import speaker from './images/speaker.jpg';
import {useNavigate} from 'react-router-dom';





export default function BodyForm(){
    const navigate = useNavigate();
    const[source, setState] = useState(question);
    const bodyInput = useRef();
    const [response, setResponse] = useState('',true);
    const [isShown, setIsShown] = useState(true);
    
    const [forAnyone, setAnyone] = useState(true);
    

   


    const mainTextHandler = (e) => {
    
        e.preventDefault();
        (async function call() {
        try {
         const connection = await fetch('http://localhost:8081/post/checkBannedWords', {
               method: 'POST',
               mode: 'cors',
               headers: {
                'Content-Type': 'application/json',},
               body: JSON.stringify(bodyInput.current.value)
             });
         const res = await connection.json();
         if(res!=undefined){
            setResponse(res);
         }
         }
         catch (error) {
             console.log('Error with fetching data!', error);
           }
         })();
        
         if(response.buttonShown === false ){
             setIsShown(current => !current);
          }
    }

  let imgHandler = (event) => {
    let radioId=event.currentTarget.id
    if(radioId==="1"){
        setState(question);
        localStorage.setItem("category",event.currentTarget.value)
        localStorage.setItem("categoryImage","question")
    }
    
    if(radioId==="2"){
        setState(speaker);
        localStorage.setItem("category",event.currentTarget.value)
        localStorage.setItem("categoryImage","speaker")
    }
    if(radioId==="3"){
        setState(pencil);
        localStorage.setItem("category",event.currentTarget.value)
        localStorage.setItem("categoryImage","pencil")
     } 
}

let preferenceHandler = (event) => {
    let radioId=event.currentTarget.id
    if(radioId=="Public"){
       setAnyone(current => !current);
    }
    
    if(radioId=="Private"){
        setAnyone(current => !current);
    }
}

const clickHandler = () =>{
    
     let finalData = {
      title: localStorage.getItem("postTitle"),
      category: localStorage.getItem("category"),
      body: bodyInput.current.value,
     image: localStorage.getItem("categoryImage"),
     forAnyone: forAnyone
    }

    
      (async function call() {
           try {
            const connection2 = await fetch('http://localhost:8081/post/create', {
                 method: 'POST',
                  mode: 'cors', 
                  body: JSON.stringify(finalData),
                  headers: {
                   'Content-Type': 'application/json',}
                 
             });
            const res1 = await connection2.json();
            console.log(res1)
           }
            catch (error) {
                console.log('Error with fetching data!', error);
              }
            })();

    navigate('/Confirmation');
}

 

    return(
        <>
        <Form onSubmit={clickHandler}>
           <div className="radioOption">
           <h5>Category</h5>
            <Form.Check inline type="radio" label="Question" value="Question" name="category" id="1"  onChange={imgHandler} defaultChecked/>
            <Form.Check inline type="radio" label="Suggestion" value="Suggestion" name="category" id="2" onChange={imgHandler}/>
            <Form.Check inline type="radio" label="Clarification" value="Clarification" name="category" id="3" onChange={imgHandler} />
           </div>
           <div className='textOption'>
            <h5>Body</h5>
            <Form.Control as="textarea" rows={3} maxLength={2000} placeholder="Max 2000 characters!" ref={bodyInput} onChangeCapture={mainTextHandler}/>
           </div>
           <div>
           <img id="image" src={source} width={200} height={200}></img>        
           </div>
           <div style={{display: isShown ? 'none' : 'block'}}> You can not use the word "{response.bannedWord}"</div>
           <div className="invisibleDiv" style={{display: isShown ? 'block' : 'none'}} >
            <h3>Preferences</h3>
            <Form.Check inline type="radio" label="Public" name="preferences" id="Public" defaultChecked onChange={preferenceHandler}/> 
            <Form.Check inline type="radio" label="Registered Users only" name="preferences" id="Private"  onChange={preferenceHandler} /><p></p>
            <button id="submit">Submit Post</button>
           </div>
        </Form>
        </>
    );
}
