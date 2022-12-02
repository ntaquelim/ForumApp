import Header from "../components/Header/Header";
import BodyForm from "../components/NewPost/BodyForm";

export default function PostBodyForm(){
    
    
    return(
    <div className="container">
    <div className="headerDiv"> <Header /> </div>
    <h3>Create the body of the post with title {localStorage.getItem("postTitle")} of the Thread {localStorage.getItem("currentThread")}</h3> 
    <div className="contentDiv"><BodyForm/></div>
    </div>);
}