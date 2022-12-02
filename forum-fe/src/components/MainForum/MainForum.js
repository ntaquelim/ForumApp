import {useNavigate} from 'react-router-dom';


export default function MainForum(){
    
    const navigate = useNavigate();

    
    const clickHandler = (event) =>{
        localStorage.setItem("currentThread",event.currentTarget.id );
        navigate('/NewPost')
    }
    
    return(
        <div>
            <button id="thread1" onClick={clickHandler}> thread 1 </button>
            <button id="thread2" onClick={clickHandler}> thread 2 </button>
            <button id="thread3" onClick={clickHandler}> thread 3 </button>
        </div>   
        );
}