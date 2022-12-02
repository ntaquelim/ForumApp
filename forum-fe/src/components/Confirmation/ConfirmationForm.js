import {useNavigate} from 'react-router-dom';

export default function ConfirmationForm(){
    
    const navigate = useNavigate();
    const clickHandler = () =>{

        navigate('/');
    }


    return(
        <div>
            <button onClick={clickHandler}>Home</button>
        </div>
    );
}