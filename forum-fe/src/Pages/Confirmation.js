import ConfirmationForm from "../components/Confirmation/ConfirmationForm";
import Header from "../components/Header/Header";

export default function Confirmation(){
    return(
    <div className="container">
       <div className="headerDiv"> <Header /> </div> 
       <h3>Your post has been published</h3>
       <div className="contentDiv"> <ConfirmationForm /></div>
    </div>);
}