import React, { useState } from 'react';
import './register.css'

const RegistrationPage = () => {
const initialFormData = {
name: '',
email: '',
password: '',
confirmPassword: '',
};

const [formData, setFormData] = useState(initialFormData);
const [errors, setErrors] = useState({});

const handleChange = (e) => {
setFormData({
...formData,
[e.target.name]: e.target.value,
});
};

const validateForm = () => {
const newErrors = {};

if (!formData.name) {
newErrors.name = 'Name is required';
}

if (!formData.email) {
newErrors.email = 'Email is required';
} else if (!/^\S+@\S+\.\S+$/.test(formData.email)) {
newErrors.email = 'Invalid email format';
}

if (!formData.password) {
newErrors.password = 'Password is required';
} else if (formData.password.length < 6) {
newErrors.password = 'Password must be at least 6 characters long';
}

if (formData.password !== formData.confirmPassword) {
newErrors.confirmPassword = 'Passwords do not match';
}

setErrors(newErrors);

return Object.keys(newErrors).length === 0;
};

const handleSubmit = (e) => {
e.preventDefault();

const isValid = validateForm();

if (isValid) {
console.log(formData);

setFormData(initialFormData);
}
};

return (
    <div className="registration-page">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

        <h2>User Registration</h2>
        <form onSubmit={handleSubmit}>
            <div className="form-field">
                <label htmlFor="name">  <i className="fas fa-user-circle"></i> Name</label>
                <input type="text" name="name" placeholder="Name" value={formData.name} onChange={handleChange} />
                {errors.name && <div className="error">{errors.name}</div>}
            </div>
            <div className="form-field">
                <label htmlFor="email">  <i className="fas fa-envelope"></i> Email</label>
                <input type="email" name="email" placeholder="Enter your email" value={formData.email} onChange={handleChange} />
                {errors.email && <div className="error">{errors.email}</div>}
            </div>

            <div className="form-field">
                <label htmlFor="password"><i className="fas fa-lock"></i> Password</label>
                <input
                    type="password"
                    name="password"
                    placeholder="Enter your password"
                    value={formData.password}
                    onChange={handleChange}
                />
                {errors.password && <div className="error">{errors.password}</div>}
            </div>

<div className="form-field">
<label htmlFor="confirmPassword"><i className="fas fa-lock"></i> Confirm Password</label>
<input
type="password"
name="confirmPassword"
placeholder="Confirm your password"
value={formData.confirmPassword}
onChange={handleChange}
/>
{errors.confirmPassword && (
<div className="error">{errors.confirmPassword}</div>
)}
</div>

<button type="submit" className="btn-submit">
Register
</button>
</form>
</div>
);
};

export default RegistrationPage;