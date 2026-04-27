import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import{BrowserRouter,Routes,Route} from 'react-router-dom' 
import ProjectHomePage from './components/ProjectHomePage.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>                                  
    <Routes>                                          
      <Route path='/'element={<ProjectHomePage/>}/>
    </Routes>
    </BrowserRouter>                                  
  </StrictMode>,
)

