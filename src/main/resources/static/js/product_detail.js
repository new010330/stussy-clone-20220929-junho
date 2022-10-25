class ProductApi {
    static #instanse = null;

    static getInstanse() {
        if(this.#instanse == null) {
            this.#instanse = new ProductApi();
        }
        return this.#instanse;
    }

    getProduct() {
        let responseData = null;
        const uri = location.href;
        const groupId = uri.substring(uri.lastIndexOf("/") + 1);

        $.ajax({
            async: false,
            type: "get",
            url: "/api/products/" + groupId,
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        });

        return responseData;
    }
}