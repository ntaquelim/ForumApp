
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import Home from './Pages/Home';
import NewPost from './Pages/NewPost';
import PostBodyForm from './Pages/PostBodyForm';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      {/* Change to the component you are developing */}
      <Route path="/" element={<Home />} /> 
      <Route path="NewPost" element={<NewPost />} />
      <Route path="PostBodyForm" element={<PostBodyForm />}/>
      <Route path="Booking" element/>
      <Route path="Confirmation" element />

    </Routes>
  </BrowserRouter>
  );
}

export default App;
