import {createGlobalStyle} from 'styled-components';

export default createGlobalStyle`

    *{
        margin: 0px;
        padding: 0px;
        outline: 0;
        box-sizing: border-box;
    }

    :root {
        --main-color: #fc3;
        --second-color: #ec6;
    }

    .main_color{color: var(--main-color) !important}
    .main_background{background-color: var(--main-color) !important}
    .second_color{color: var(--second-color) !important}
    .second_background{background-color: var(--second-color) !important}

`;
