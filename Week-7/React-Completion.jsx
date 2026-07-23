import { createContext, useContext, useState } from 'react';
const ThemeContext = createContext('light');
function Status() { const theme = useContext(ThemeContext); return <p>Current theme: {theme}</p>; }
export default function App() { const [theme, setTheme] = useState('light'); return <ThemeContext.Provider value={theme}><main><h1>React HOL 9–17</h1><Status /><button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>Toggle theme</button></main></ThemeContext.Provider>; }
