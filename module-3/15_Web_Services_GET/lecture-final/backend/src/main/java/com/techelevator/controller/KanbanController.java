package com.techelevator.controller;

import com.techelevator.dao.kanban.KanbanDAO;
import com.techelevator.model.kanban.Board;
import com.techelevator.model.kanban.Card;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class KanbanController {

    private KanbanDAO kanbanDAO;

    public KanbanController(KanbanDAO kanbanDAO) {
        this.kanbanDAO = kanbanDAO;
    }

    @GetMapping("/boards")
    public List<Board> getBoards() throws InterruptedException {
        Thread.sleep(2000); //Simulated loading time

        return kanbanDAO.getAllBoards();
    }

    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Board result = kanbanDAO.getBoard(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No board with that id.");
        } else {
            return result;
        }
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Card result = kanbanDAO.getCard(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No card with that id.");
        } else {
            return result;
        }
    }

    @PostMapping("/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public Board postBoard(@RequestBody Board newBoard) {
        return kanbanDAO.createBoard(newBoard);
    }


}
