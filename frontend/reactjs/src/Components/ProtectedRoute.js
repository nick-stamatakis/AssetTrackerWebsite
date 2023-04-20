import { Navigate, Outlet } from 'react-router-dom'

const ProtectedRoute = () => {
    let auth = localStorage.getItem('isAuthenticated');
    return (
        auth ? <Outlet/> : <Navigate to='/'/>
    )
}

export default ProtectedRoute