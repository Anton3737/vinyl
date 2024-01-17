package vinyl.MyRecords.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vinyl.MyRecords.dao.RecordsDAO;
import vinyl.MyRecords.models.Vinyls;

import javax.validation.Valid;


@Controller
@RequestMapping("/recordspage")
public class RecController {

    private final RecordsDAO recordsDAO;

    @Autowired
    public RecController(RecordsDAO recordsDAO) {
        this.recordsDAO = recordsDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("records", recordsDAO.index());
        return "recordspage/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("records", recordsDAO.show(id));
        return "recordspage/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("records") Vinyls vinyls) {
        return "recordspage/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("records") @Valid Vinyls vinyls,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "recordspage/new";

        recordsDAO.save(vinyls);
        return "redirect:/recordspage";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("records", recordsDAO.show(id));
        return "recordspage/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("records") @Valid Vinyls vinyls, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "recordspage/edit";

        recordsDAO.update(id, vinyls);
        return "redirect:/recordspage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        recordsDAO.delete(id);
        return "redirect:/recordspage";
    }


}
