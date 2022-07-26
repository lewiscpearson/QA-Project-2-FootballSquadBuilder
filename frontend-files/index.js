"use strict";

document.querySelector("body > form").addEventListener("submit", function (event){
    event.preventDefault();
    console.log("THIS: ", this);

    const data = {
        name: this.name.value,
        position: this.position.value,
        age: this.age.value,
        nationality: this.nationality.value        
    }

    console.log("DATA:", data)
    axios.post("http://localhost:8080/createPlayer", data)
    .then(res => {
        console.log("RES: ", res);
        this.name.focus();
        this.reset();
        renderPlayers();
    })
    .catch(err => console.error(err));

    console.log("player: ", data);
});

const output = document.querySelector("#output")

function renderPlayers() { 
    axios.get("http://localhost:8080/getPlayers/")
        .then(res => {
            console.log("players: ", res.data);
            output.innerHTML = "";
            for (let player of res.data) {
                const playerCol = document.createElement("div");
                playerCol.className = "col";

                const playerCard = document.createElement("div");
                playerCard.className = "card";
                playerCol.appendChild(playerCard);

                const playerDiv = document.createElement("div");
                playerDiv.className = "card-body";
                playerCard.appendChild(playerDiv);

                const playerName = document.createElement("h2");
                playerName.innerText = player.name;
                playerDiv.appendChild(playerName);

                const playerPosition = document.createElement("p");
                playerPosition.innerText = player.position;
                playerDiv.appendChild(playerPosition);

                const playerAge = document.createElement("p");
                playerAge.innerText = player.age + " years old.";
                playerDiv.appendChild(playerAge);

                const playerNationality = document.createElement("p");
                playerNationality.innerText = player.Nationality;
                playerDiv.appendChild(playerNationality);
            

                const playerDelete = document.createElement('button');
                playerDelete.innerText="DELETE";
                playerDelete.addEventListener("click", () => {
                    console.log("player: ", player);
                    deleteplayer(player.id);
                });
                playerDiv.appendChild(playerDelete);

                output.appendChild(playerCol);
            }
        })
        .catch(err => console.error(err));
}

const deletePlayer = (id) => {
    axios.delete("http://localhost:8080/deletePlayer/" + id)
            .then(res => {
                console.log("Player deleted successfully");
                renderPlayers();
            }).catch(err => console.error(err));
}

renderPlayers();