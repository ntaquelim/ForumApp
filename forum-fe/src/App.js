
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import Home from './Pages/Home';
import NewPost from './Pages/NewPost';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      {/* Change to the component you are developing */}
      
      <Route path="/" element={<Home />} /> 
      <Route path="NewPost" element={<NewPost />} />
      <Route path="Passengers" element />
      {/*<Route path="Seats" element={<Seats/>} />
       <Route path="personal" element={} /> */}
      <Route path="Booking" element/>
      <Route path="Confirmation" element />

    </Routes>
  </BrowserRouter>
  );
}

export default App;
