
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import Home from './Pages/Home';
import NewPost from './Pages/NewPost';
import PostBodyForm from './Pages/PostBodyForm';
import Confirmation from './Pages/Confirmation';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      {/* Change to the component you are developing */}
      <Route path="/" element={<Home />} /> 
      <Route path="NewPost" element={<NewPost />} />
      <Route path="PostBodyForm" element={<PostBodyForm />}/>
      <Route path="Confirmation" element={<Confirmation />} />

    </Routes>
  </BrowserRouter>
  );
}

export default App;
