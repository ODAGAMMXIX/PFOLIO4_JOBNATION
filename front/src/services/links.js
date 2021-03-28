export function Links (link){

    const listLinks = {
        dashboard: {to: '/dashboard', label: 'Dashboard'},
        config: {to: '/config', label: 'Configurações'},
        jobs: {to: '/jobs', label: 'Lista de vagas'},
    }

    return listLinks[link]
}