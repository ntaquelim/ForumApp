import NewPostForm from "../components/NewPost/NewPostForm";
import Header from "../components/Header/Header";

export default function NewPost(){
    return(
        <div className="container">
            <div className="headerDiv"> <Header /> </div> 
            <h3>Creating a Post in {localStorage.getItem("currentThread")}</h3>
            <div className="contentDiv"><NewPostForm /></div>
        </div>
    );
}