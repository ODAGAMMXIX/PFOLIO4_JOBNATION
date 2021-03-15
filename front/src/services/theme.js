export function GetDefaultTheme(){
    return {
        main_color: "#2196F3",
        second_color: "#9C27B0",
        success_color: "#4CAF50",
        danger_color: "#F44336",
        warning_color: "#FFC107",
        info_color: "#00BCD4",
        inverse_color: "#FF5722",
        dark_color: "#333",
        light_color: "#fff",
        white_color: "#fff",
        menu_color: "#2196F3",
        submenu_color: "#00BCD4",
        header_color: "#FFF",
        text_color: "#333",
        title_color: "#333",
        link_color: "#2196F3",
        gray_color: "#666",
    }
}

export const GetTheme = {
    getThemeJson: () => {
        if(localStorage.getItem("config")){
            const theme = JSON.parse(localStorage.getItem("config").replace(/'/g,'"'))
            return theme;
        }
        
    },
    parseThemetoJson: (string) => {
        const theme = JSON.parse(string.replace(/'/g,'"'))
        return theme;
    },

    parseThemeToString: (json) =>{
        const theme = JSON.stringify(json).replace(/"/g,"'")
        return theme;
    },

    getConfigJson: (key) => {
        if(localStorage.getItem("config")){
            const theme = JSON.parse(localStorage.getItem("config").replace(/'/g,'"'));
            const color = theme[key];
            return color;
        }else{
            const theme = GetDefaultTheme();
            const color = theme[key];
            return color;
        }
    },
    getThemeLogo: () => {
        const logo = localStorage.getItem("logo");
        return logo;
    }
}

export function GetLocalConfig(){
    const config = localStorage.getItem("config");
    return config;
}

export function JsonToStringSetLocal(){
    const jsonString = JSON.stringify(GetDefaultTheme()).replace(/"/g,"'")
    localStorage.setItem("config", jsonString);
}