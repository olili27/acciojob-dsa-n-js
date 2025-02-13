function deepCopy(obj) {
    if(obj == null || typeof obj !== "object") {
        return obj;
    }

    if(Array.isArray(obj)) {
        const arrCopy = [];

        for(let i = 0; i < obj.length; i++) {
            arrCopy[i] = deepCopy(obj[i]);
        }

        return arrCopy
    }

    const copy = {};

    for(let key in obj) {
        if(obj.hasOwnProperty(key)) {
            copy[key] = deepCopy[obj[key]];
        }
    }

    return copy;
}