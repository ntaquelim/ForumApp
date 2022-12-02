import Header from "../components/Header/Header";
import Title from "../components/NewPost/Title";

export default function NewPost(){
    return(
        <div className="container">
            <div className="headerDiv"> <Header /> </div> 
            <h3>Creating a Post in {localStorage.getItem("currentThread")}</h3>
            <div className="contentDiv"><Title /></div>
        </div>
    );
}