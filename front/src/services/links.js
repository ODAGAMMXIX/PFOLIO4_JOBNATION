export function Links (link){

    const listLinks = {
        dashboard: {to: '/dashboard', label: 'Dashboard'},
        config: {to: '/config', label: 'Configurações'},
    }

    return listLinks[link]
}