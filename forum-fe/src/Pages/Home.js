import Header from "../components/Header/Header";
import MainForum from "../components/MainForum/MainForum";

export default function Home(){
    return(
    <div className="container">
       <div className="headerDiv"> <Header /> </div> 
       <div className="contentDiv"><MainForum/> </div>
    </div>);
}