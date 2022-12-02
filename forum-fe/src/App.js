
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './Pages/Home';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      {/* Change to the component you are developing */}
      
      <Route path="/" element={<Home />} /> 
      <Route path="Flights" element />
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
